import axios from '../../utils/axios'

export function addAssignment(data) {
    return axios.post('/admin/assignment', data)
}

export function getAssignmentPage(params) {
    return axios.get('/admin/assignment/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchAssignment(ids) {
    return axios.delete('/admin/assignment/batch', {
        data: ids
    });
} 