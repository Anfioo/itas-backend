import axios from '../../utils/axios'

export function addClassMember(data) {
    return axios.post('/admin/class-member', data)
}

export function getClassMemberPage(params) {
    return axios.get('/admin/class-member/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchClassMember(ids) {
    return axios.delete('/admin/class-member/batch', {
        data: ids
    });
} 