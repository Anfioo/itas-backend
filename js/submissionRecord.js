import axios from '../../utils/axios'

export function addSubmissionRecord(data) {
    return axios.post('/admin/submission-record', data)
}

export function getSubmissionRecordPage(params) {
    return axios.get('/admin/submission-record/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query
        }
    });
}

export function removeBatchSubmissionRecord(ids) {
    return axios.delete('/admin/submission-record/batch', {
        data: ids
    });
} 